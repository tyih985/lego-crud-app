import React from "react";

type Props = { onChange: (filters: Record<string, any>) => void };

export default function Filters({ onChange }: Props) {
    const [theme, setTheme] = React.useState("");
    const [name, setName] = React.useState("");
    const [minPieces, setMinPieces] = React.useState("");
    const [minMinifigs, setMinMinifigs] = React.useState("");
    const [minAge, setMinAge] = React.useState("");
    const [maxPrice, setMaxPrice] = React.useState("");

    React.useEffect(() => {
        const t = setTimeout(() => {
            onChange({
                theme: theme || undefined,
                name: name || undefined,
                minPieces: minPieces ? Number(minPieces) : undefined,
                minMinifigs: minMinifigs ? Number(minMinifigs) : undefined,
                minAge: minAge ? Number(minAge) : undefined,
                maxPrice: maxPrice ? Number(maxPrice) : undefined,
            });
        }, 300);
        return () => clearTimeout(t);
    }, [theme, name, minPieces, minMinifigs, minAge, maxPrice, onChange]);

    return (
        <div style={{ display: "flex", gap: 8, flexWrap: "wrap", marginBottom: 16 }}>
            <input placeholder="Theme" value={theme} onChange={(e) => setTheme(e.target.value)} />
            <input placeholder="Name contains" value={name} onChange={(e) => setName(e.target.value)} />
            <input placeholder="Min pieces" value={minPieces} onChange={(e) => setMinPieces(e.target.value)} />
            <input placeholder="Min minifigs" value={minMinifigs} onChange={(e) => setMinMinifigs(e.target.value)} />
            <input placeholder="Min age" value={minAge} onChange={(e) => setMinAge(e.target.value)} />
            <input placeholder="Max price" value={maxPrice} onChange={(e) => setMaxPrice(e.target.value)} />
        </div>
    );
}
