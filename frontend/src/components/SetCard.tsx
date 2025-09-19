import type { LegoSet } from "../types";

export default function SetCard({ set }: { set: LegoSet }) {
    return (
        <div style={{ border: "1px solid #ddd", padding: 12, borderRadius: 8, background: "#fff" }}>
            {set.thumbnailUrl ? (
                <img src={set.thumbnailUrl} alt={set.name} style={{ width: "100%", height: 140, objectFit: "cover" }} />
            ) : null}
            <h3 style={{ margin: "8px 0" }}>{set.name}</h3>
            <div>Theme: {set.theme}</div>
            <div>Year: {set.year ?? "—"} • Pieces: {set.pieces ?? "—"}</div>
            <div>Minifigs: {set.minifigs ?? "—"} • Age: {set.ageRangeMin ?? "—"}</div>
            <div>Price: {set.usRetailPrice ?? "—"}</div>
            <div style={{ marginTop: 8 }}>
                {set.bricksetUrl ? <a href={set.bricksetUrl} target="_blank" rel="noreferrer">Brickset</a> : null}
            </div>
        </div>
    );
}
